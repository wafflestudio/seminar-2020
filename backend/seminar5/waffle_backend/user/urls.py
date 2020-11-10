from django.urls import include, path
from rest_framework.routers import SimpleRouter

from user.views import UserViewSet

app_name = 'user'

router = SimpleRouter()
router.register('user', UserViewSet, basename='user')  # /api/v1/user/

urlpatterns = [
    path('', include((router.urls))),
]
