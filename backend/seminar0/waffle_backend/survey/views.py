from django.shortcuts import get_object_or_404
from rest_framework import viewsets
from rest_framework.response import Response

from survey.serializers import SurveyResultSerializer
from survey.models import SurveyResult


class SurveyResultViewSet(viewsets.GenericViewSet):
    queryset = SurveyResult.objects.all()
    serializer_class = SurveyResultSerializer

    # GET /api/v1/survey/
    def list(self, request):
        surveys = self.get_queryset()
        return Response(self.get_serializer(surveys, many=True).data)

    # GET /api/v1/survey/{surveyresult_id}/
    def retrieve(self, request, pk=None):
        survey = get_object_or_404(SurveyResult, pk=pk)
        return Response(self.get_serializer(survey).data)
