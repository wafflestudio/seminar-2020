from rest_framework import status, viewsets
from rest_framework.permissions import AllowAny, IsAuthenticated
from rest_framework.response import Response

from survey.serializers import OperatingSystemSerializer, SurveyResultSerializer
from survey.models import OperatingSystem, SurveyResult


class SurveyResultViewSet(viewsets.GenericViewSet):
    queryset = SurveyResult.objects.all()
    serializer_class = SurveyResultSerializer
    permission_classes = (IsAuthenticated, )

    def get_permissions(self):
        if self.action in ('list', 'retrieve'):
            return (AllowAny(), )
        return super(SurveyResultViewSet, self).get_permissions()

    def list(self, request):
        surveys = self.get_queryset().select_related('os', 'user')
        return Response(self.get_serializer(surveys, many=True).data)

    def retrieve(self, request, pk=None):
        survey = self.get_object()
        return Response(self.get_serializer(survey).data)

    def create(self, request):
        data = request.data.copy()
        data.update(os_name=data.get('os'))

        serializer = self.get_serializer(data=data)
        serializer.is_valid(raise_exception=True)
        serializer.save()
        return Response(serializer.data, status=status.HTTP_201_CREATED)


class OperatingSystemViewSet(viewsets.GenericViewSet):
    queryset = OperatingSystem.objects.all()
    serializer_class = OperatingSystemSerializer

    def list(self, request):
        return Response(self.get_serializer(self.get_queryset(), many=True).data)

    def retrieve(self, request, pk=None):
        os = self.get_object()
        return Response(self.get_serializer(os).data)
