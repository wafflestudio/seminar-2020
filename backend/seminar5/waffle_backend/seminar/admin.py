from django.contrib import admin

from seminar.models import Seminar


class CountFilter(admin.SimpleListFilter):
    title = '인원 수'
    parameter_name = 'capacity_filter'

    def lookups(self, request, model_admin):
        return [
            ('gte30', '30명 이상'),
            ('lt30', '30명 미만')
        ]

    def queryset(self, request, queryset):
        if self.value() == 'gte30':
            queryset = queryset.filter(capacity__gte=30)
        elif self.value() == 'lt30':
            queryset = queryset.filter(capacity__lt=30)
        return queryset


class SeminarAdmin(admin.ModelAdmin):
    list_display = ('id', 'name', 'capacity', 'count', 'time', 'online', 'created_at', 'updated_at')
    list_filter = ('online', CountFilter)
    search_fields = ('name', 'user_seminars__user__username')
    actions = ('make_online', 'make_offline')

    def make_online(self, request, queryset):
        rows_updated = queryset.update(online=True)
        self.message_user(request, f"Made {rows_updated} seminars online!")

    def make_offline(self, request, queryset):
        rows_updated = queryset.update(online=False)
        self.message_user(request, f"Made {rows_updated} seminars offline!")


admin.site.register(Seminar, SeminarAdmin)
