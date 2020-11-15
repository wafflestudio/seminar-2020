from django.contrib.auth.models import User
from django.test import Client, TestCase
from rest_framework import status
from rest_framework.authtoken.models import Token
import json

from user.models import InstructorProfile, ParticipantProfile


class PostUserTestCase(TestCase):
    client = Client()

    def setUp(self):
        self.client.post(
            '/api/v1/user/',
            json.dumps({
                "username": "davin111",
                "password": "password",
                "first_name": "Davin",
                "last_name": "Byeon",
                "email": "bdv111@snu.ac.kr",
                "role": "participant",
                "university": "서울대학교"
            }),
            content_type='application/json'
        )

    def test_post_user_duplicated_username(self):
        response = self.client.post(
            '/api/v1/user/',
            json.dumps({
                "username": "davin111",
                "password": "password",
                "first_name": "Davin",
                "last_name": "Byeon",
                "email": "bdv111@snu.ac.kr",
                "role": "participant",
                "university": "서울대학교"
            }),
            content_type='application/json'
        )
        self.assertEqual(response.status_code, status.HTTP_400_BAD_REQUEST)

        user_count = User.objects.count()
        self.assertEqual(user_count, 1)

    def test_post_user_incomplete_request(self):
        response = self.client.post(
            '/api/v1/user/',
            json.dumps({
                "username": "participant",
                "password": "password",
                "first_name": "Davin",
                "last_name": "Byeon",
                "email": "bdv111@snu.ac.kr",
                "role": "wrong_role",
                "university": "서울대학교"
            }),
            content_type='application/json'
        )
        self.assertEqual(response.status_code, status.HTTP_400_BAD_REQUEST)

        response = self.client.post(
            '/api/v1/user/',
            json.dumps({
                "username": "participant",
                "password": "password",
                "first_name": "Davin",
                "last_name": "Byeon",
                "email": "bdv111@snu.ac.kr",
                "university": "서울대학교"
            }),
            content_type='application/json'
        )
        self.assertEqual(response.status_code, status.HTTP_400_BAD_REQUEST)

        response = self.client.post(
            '/api/v1/user/',
            json.dumps({
                "username": "participant",
                "password": "password",
                "first_name": "Davin",
                "last_name": "Byeon",
                "role": "participant",
                "university": "서울대학교"
            }),
            content_type='application/json'
        )
        self.assertEqual(response.status_code, status.HTTP_400_BAD_REQUEST)

        user_count = User.objects.count()
        self.assertEqual(user_count, 1)

    def test_post_user(self):
        response = self.client.post(
            '/api/v1/user/',
            json.dumps({
                "username": "davin111",
                "password": "password",
                "first_name": "Davin",
                "last_name": "Byeon",
                "email": "bdv111@snu.ac.kr",
                "role": "participant",
                "university": "서울대학교"
            }),
            content_type='application/json'
        )
        self.assertEqual(response.status_code, status.HTTP_400_BAD_REQUEST)

        user_count = User.objects.count()
        self.assertEqual(user_count, 1)

        response = self.client.post(
            '/api/v1/user/',
            json.dumps({
                "username": "participant",
                "password": "password",
                "first_name": "Davin",
                "last_name": "Byeon",
                "email": "bdv111@snu.ac.kr",
                "role": "participant",
                "university": "서울대학교"
            }),
            content_type='application/json'
        )
        self.assertEqual(response.status_code, status.HTTP_201_CREATED)

        data = response.json()
        self.assertIn("id", data)
        self.assertEqual(data["username"], "participant")
        self.assertEqual(data["email"], "bdv111@snu.ac.kr")
        self.assertEqual(data["first_name"], "Davin")
        self.assertEqual(data["last_name"], "Byeon")
        self.assertIn("last_login", data)
        self.assertIn("date_joined", data)
        self.assertIn("token", data)

        participant = data["participant"]
        self.assertIsNotNone(participant)
        self.assertIn("id", participant)
        self.assertEqual(participant["university"], "서울대학교")
        self.assertTrue(participant["accepted"])
        self.assertEqual(len(participant["seminars"]), 0)

        self.assertIsNone(data["instructor"])

        user_count = User.objects.count()
        self.assertEqual(user_count, 2)
        participant_count = ParticipantProfile.objects.count()
        self.assertEqual(participant_count, 2)
        instructor_count = InstructorProfile.objects.count()
        self.assertEqual(instructor_count, 0)


class PutUserMeTestCase(TestCase):
    client = Client()

    def setUp(self):
        self.client.post(
            '/api/v1/user/',
            json.dumps({
                "username": "part",
                "password": "password",
                "first_name": "Davin",
                "last_name": "Byeon",
                "email": "bdv111@snu.ac.kr",
                "role": "participant",
                "university": "서울대학교"
            }),
            content_type='application/json'
        )
        self.participant_token = 'Token ' + Token.objects.get(user__username='part').key

        self.client.post(
            '/api/v1/user/',
            json.dumps({
                "username": "inst",
                "password": "password",
                "first_name": "Davin",
                "last_name": "Byeon",
                "email": "bdv111@snu.ac.kr",
                "role": "instructor",
                "year": 1
            }),
            content_type='application/json'
        )
        self.instructor_token = 'Token ' + Token.objects.get(user__username='inst').key

    def test_put_user_incomplete_request(self):
        response = self.client.put(
            '/api/v1/user/me/',
            json.dumps({
                "first_name": "Dabin"
            }),
            content_type='application/json'
        )
        self.assertEqual(response.status_code, status.HTTP_401_UNAUTHORIZED)

        response = self.client.put(
            '/api/v1/user/me/',
            json.dumps({
                "first_name": "Dabin"
            }),
            content_type='application/json',
            HTTP_AUTHORIZATION=self.participant_token
        )
        self.assertEqual(response.status_code, status.HTTP_400_BAD_REQUEST)

        participant_user = User.objects.get(username='part')
        self.assertEqual(participant_user.first_name, 'Davin')

        response = self.client.put(
            '/api/v1/user/me/',
            json.dumps({
                "username": "inst123",
                "email": "bdv111@naver.com",
                "company": "매스프레소",
                "year": -1
            }),
            content_type='application/json',
            HTTP_AUTHORIZATION=self.instructor_token
        )
        self.assertEqual(response.status_code, status.HTTP_400_BAD_REQUEST)

        instructor_user = User.objects.get(username='inst')
        self.assertEqual(instructor_user.email, 'bdv111@snu.ac.kr')

    def test_put_user_me_participant(self):
        response = self.client.put(
            '/api/v1/user/me/',
            json.dumps({
                "username": "part123",
                "email": "bdv111@naver.com",
                "university": "경북대학교"
            }),
            content_type='application/json',
            HTTP_AUTHORIZATION=self.participant_token
        )
        self.assertEqual(response.status_code, status.HTTP_200_OK)

        data = response.json()
        self.assertIn("id", data)
        self.assertEqual(data["username"], "part123")
        self.assertEqual(data["email"], "bdv111@naver.com")
        self.assertEqual(data["first_name"], "Davin")
        self.assertEqual(data["last_name"], "Byeon")
        self.assertIn("last_login", data)
        self.assertIn("date_joined", data)
        self.assertNotIn("token", data)

        participant = data["participant"]
        self.assertIsNotNone(participant)
        self.assertIn("id", participant)
        self.assertEqual(participant["university"], "경북대학교")
        self.assertTrue(participant["accepted"])
        self.assertEqual(len(participant["seminars"]), 0)

        self.assertIsNone(data["instructor"])
        participant_user = User.objects.get(username='part123')
        self.assertEqual(participant_user.email, 'bdv111@naver.com')

    def test_put_user_me_instructor(self):
        response = self.client.put(
            '/api/v1/user/me/',
            json.dumps({
                "username": "inst123",
                "email": "bdv111@naver.com",
                "first_name": "Dabin",
                "last_name": "Byeon",
                "university": "서울대학교",  # this should be ignored
                "company": "매스프레소",
                "year": 2
            }),
            content_type='application/json',
            HTTP_AUTHORIZATION=self.instructor_token
        )
        self.assertEqual(response.status_code, status.HTTP_200_OK)

        data = response.json()
        self.assertIn("id", data)
        self.assertEqual(data["username"], "inst123")
        self.assertEqual(data["email"], "bdv111@naver.com")
        self.assertEqual(data["first_name"], "Dabin")
        self.assertEqual(data["last_name"], "Byeon")
        self.assertIn("last_login", data)
        self.assertIn("date_joined", data)
        self.assertNotIn("token", data)

        self.assertIsNone(data["participant"])

        instructor = data["instructor"]
        self.assertIsNotNone(instructor)
        self.assertIn("id", instructor)
        self.assertEqual(instructor["company"], "매스프레소")
        self.assertEqual(instructor["year"], 2)
        self.assertIsNone(instructor["charge"])

        instructor_user = User.objects.get(username='inst123')
        self.assertEqual(instructor_user.email, 'bdv111@naver.com')
