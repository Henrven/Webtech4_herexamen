from django.shortcuts import render
import json

def index(request, aantal):
    with open('infractions.json') as data_file:
        infractionsjson = json.load(data_file)

    overtredingen = []
    for x in infractionsjson:
        if x["infractions_speed"] >= aantal:
            overtredingen.append(x)

    overtredingen.sort(key=lambda x: x.infractions_speed)
       
    context = {
        "overtredingenlijst": overtredingen
    }

    return render(request, "index.html", context)


# Create your views here.
