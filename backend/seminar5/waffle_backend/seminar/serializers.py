from rest_framework import serializers

from seminar.models import Seminar, UserSeminar


class SeminarSerializer(serializers.ModelSerializer):
    time = serializers.TimeField(format='%H:%M', input_formats=['%H:%M'])
    online = serializers.BooleanField(default=True)
    instructors = serializers.SerializerMethodField()
    participants = serializers.SerializerMethodField()

    class Meta:
        model = Seminar
        fields = (
            'id',
            'name',
            'capacity',
            'count',
            'time',
            'online',
            'instructors',
            'participants',
        )

    def get_instructors(self, seminar):
        instructor_seminars = seminar.user_seminars.filter(role=UserSeminar.INSTRUCTOR)
        return InstructorOfSeminarSerializer(instructor_seminars, many=True, context=self.context).data

    def get_participants(self, seminar):
        participant_seminars = seminar.user_seminars.filter(role=UserSeminar.PARTICIPANT)
        return ParticipantOfSeminarSerializer(participant_seminars, many=True, context=self.context).data


class SimpleSeminarSerializer(serializers.ModelSerializer):
    instructors = serializers.SerializerMethodField()
    participant_count = serializers.SerializerMethodField()

    class Meta:
        model = Seminar
        fields = (
            'id',
            'name',
            'instructors',
            'participant_count'
        )

    def get_instructors(self, seminar):
        instructor_seminars = seminar.user_seminars.filter(role=UserSeminar.INSTRUCTOR)
        return InstructorOfSeminarSerializer(instructor_seminars, many=True, context=self.context).data

    def get_participant_count(self, seminar):
        return seminar.user_seminars.filter(role=UserSeminar.PARTICIPANT, is_active=True).count()


class InstructorOfSeminarSerializer(serializers.ModelSerializer):
    joined_at = serializers.DateTimeField(source='created_at')
    id = serializers.IntegerField(source='user.id')
    username = serializers.CharField(source='user.username')
    email = serializers.EmailField(source='user.email')
    first_name = serializers.CharField(source='user.first_name')
    last_name = serializers.CharField(source='user.last_name')

    class Meta:
        model = UserSeminar
        fields = (
            'joined_at',
            'id',
            'username',
            'email',
            'first_name',
            'last_name',
        )


class ParticipantOfSeminarSerializer(serializers.ModelSerializer):
    joined_at = serializers.DateTimeField(source='created_at')
    id = serializers.IntegerField(source='user.id')
    username = serializers.CharField(source='user.username')
    email = serializers.EmailField(source='user.email')
    first_name = serializers.CharField(source='user.first_name')
    last_name = serializers.CharField(source='user.last_name')

    class Meta:
        model = UserSeminar
        fields = (
            'joined_at',
            'is_active',
            'dropped_at',
            'id',
            'username',
            'email',
            'first_name',
            'last_name',
        )


class SeminarAsParticipantSerializer(serializers.ModelSerializer):
    joined_at = serializers.DateTimeField(source='created_at')
    id = serializers.IntegerField(source='seminar.id')
    name = serializers.CharField(source='seminar.name')

    class Meta:
        model = UserSeminar
        fields = (
            'joined_at',
            'id',
            'name',
            'is_active',
            'dropped_at',
        )


class SeminarAsInstructorSerializer(serializers.ModelSerializer):
    joined_at = serializers.DateTimeField(source='created_at')
    id = serializers.IntegerField(source='seminar.id')
    name = serializers.CharField(source='seminar.name')

    class Meta:
        model = UserSeminar
        fields = (
            'joined_at',
            'id',
            'name',
        )
