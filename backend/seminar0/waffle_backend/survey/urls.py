from django.urls import include, path
from rest_framework.routers import SimpleRouter
from survey.views import SurveyViewSet

app_name = 'survey'

router = SimpleRouter()
router.register('survey', SurveyViewSet, basename='survey')  # /api/v1/survey/

urlpatterns = [
    path('', include((router.urls))),
]
