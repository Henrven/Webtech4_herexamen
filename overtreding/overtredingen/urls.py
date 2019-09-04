from django.conf.urls import url

from . import views

urlpatterns = [
    url('/<int:aantal>/', views.index, name='index')
    ]