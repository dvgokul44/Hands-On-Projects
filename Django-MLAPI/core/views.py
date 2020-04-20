from django.shortcuts import render

# Create your views here.
def core_app(request):
    return render(request,'index.html')
    