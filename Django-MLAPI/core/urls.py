from django.contrib import admin
from django.urls import path


from .views import core_app

urlpatterns = [
    path('', core_app, name = 'core')
] 
