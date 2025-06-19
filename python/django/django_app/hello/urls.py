#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Apr 10 23:51:35 2019

@author: takuma
"""
from django.conf.urls import url
from . import views

urlpatterns = [
        url('',views.index,name='index'),
]


