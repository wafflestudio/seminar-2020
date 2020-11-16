from django.db import models
from django.contrib.auth.models import User


class Seminar(models.Model):
    name = models.CharField(max_length=50, db_index=True)
    capacity = models.PositiveSmallIntegerField()
    count = models.PositiveSmallIntegerField()
    time = models.TimeField()
    online = models.BooleanField(default=True)
    created_at = models.DateTimeField(auto_now_add=True, db_index=True)
    updated_at = models.DateTimeField(auto_now=True)


class UserSeminar(models.Model):
    PARTICIPANT = 'participant'
    INSTRUCTOR = 'instructor'

    ROLE_CHOICES = (
        (PARTICIPANT, PARTICIPANT),
        (PARTICIPANT, INSTRUCTOR),
    )

    ROLES = (PARTICIPANT, INSTRUCTOR)

    user = models.ForeignKey(User, related_name='user_seminars', on_delete=models.CASCADE)
    seminar = models.ForeignKey(Seminar, related_name='user_seminars', on_delete=models.CASCADE)
    role = models.CharField(max_length=20, choices=ROLE_CHOICES, db_index=True)
    is_active = models.BooleanField(default=True)
    dropped_at = models.DateTimeField(null=True)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    class Meta:
        unique_together = (
            ('user', 'seminar'),
        )
