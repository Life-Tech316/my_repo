from django.shortcuts import render
from django.http import HttpResponse
from django.views.generic import TemplateView 
from .models import Friend
from .forms import HelloForm


def index(request):
    
    params = {
            'title':'Hello',
            'message':'all friends',
            'form':HelloForm(),
            'data':[],
            }
    
    if(request.method == 'POST'):
        num=request.POST['id']
        item = Friend.objects.get(id=num)
        params['data'] = [item]
        params['form'] = HelloForm(request.POST)
        
    else:
        params['data'] = Friend.objects.all();
        
    return render(request,'hello/index.html',params)



#クラスの定義
'''
class HelloView(TemplateView):
    
    def __init__(self):
        self.params = {
                'title':'Hello',
                'form' : HelloForm(),
                'result':None
              }
        
    def get(self,request):
        return render(request,'hello/index.html',self.params)
        
    def post(self,request):
        ch = request.POST.getlist('choice')
        self.params['result'] = 'you selected:' + str(ch) +'.'
        self.params['form'] = HelloForm(request.POST)
        return render(request,'hello/index.html',self.params)
'''
    
# Create your views here.
