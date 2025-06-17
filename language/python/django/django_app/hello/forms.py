# -*- coding: utf-8 -*-
from django import forms

#継承
class HelloForm(forms.Form):
    #check = forms.BooleanField(label='Chekbox',required=False)
    #check= forms.NullBooleanField(label='Check')
    
    id = forms.IntegerField(label='ID')
    '''
    data=[
            ('one','item 1'),
            ('two','item 2'),
            ('three','item 3'),
            ('four','item 4'),
            ('five','item 5'),
            ]
    choice = forms.MultipleChoiceField(label='radio',choices=data,widget=forms.SelectMultiple(attrs={'size':6}))

    
    
    name = forms.CharField(label='name')
    mail = forms.CharField(label='mail')
    age = forms.IntegerField(label='age')
    '''