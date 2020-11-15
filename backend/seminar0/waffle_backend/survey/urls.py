from django.urls import include, path
from rest_framework.routers import SimpleRouter
from survey.views import SurveyResultViewSet

app_name = 'survey'

router = SimpleRouter()
router.register('survey', SurveyResultViewSet, basename='survey')  # /api/v1/survey/

urlpatterns = [
    path('', include((router.urls))),
]
