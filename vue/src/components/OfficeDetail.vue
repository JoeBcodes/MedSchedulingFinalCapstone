<template>
    <div id="apptList">
        <div class="appointment">
            {{office.name}}
            {{office.address}}
            {{office.phone}}
            {{office.email}}
            {{office.startHours}}
            {{office.endHours}}
            {{office.specialty}}
            {{office.hourlyRate}}
        </div>
    </div>
</template>

<script>
import OfficeService from '../services/OfficeService.js';

export default {
    name: "office-detail",
    methods: {
        retrieveOfficeDetails() {
            OfficeService.getOfficeInfoById(1).then(response => {
                this.$store.commit("SET_OFFICE", response.data);
                console.log(response);
            });
        }
    },
    computed: {
        office() { return this.$store.state.office }
    },
    created() {
            this.retrieveOfficeDetails();
    }
}
</script>
