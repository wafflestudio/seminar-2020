from django.core.management.base import BaseCommand
import os

from survey.models import OperatingSystem, SurveyResult

TSV_FILE = '$HOME'

def download_survey():
    tsv_file = f"{os.getenv('HOME')}/Documents/Wafflestudio 18.5 Rookies Backend 세미나를 위한 설문(응답) - 설문지 응답 시트.tsv"

    OperatingSystem.objects.get_or_create(name='Windows', price=200000, description="Most favorite OS in South Korea")
    OperatingSystem.objects.get_or_create(name='MacOS', price=300000, description="Most favorite OS of Seminar Instructors")
    OperatingSystem.objects.get_or_create(name='Linux', price=0, description="Linus Benedict Torvalds")

    with open(tsv_file) as f:
        for idx, line in enumerate(f, start=1):
            if idx < 2:
                continue

            data = line.split('\t')

            operating_system, created = OperatingSystem.objects.get_or_create(name=data[1])
            SurveyResult.objects.create(timestamp=data[0], os=operating_system, python=int(data[2]), rdb=int(data[3]),
                                        programming=int(data[4]), major=data[5], grade=data[6],
                                        backend_reason=data[7], waffle_reason=data[8], say_something=data[9])


class Command(BaseCommand):

    def handle(self, *args, **options):
        download_survey()
