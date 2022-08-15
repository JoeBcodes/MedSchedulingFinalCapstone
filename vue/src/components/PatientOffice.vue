<template>
    <div id="officeList">
        <div class="office" v-for="office in this.$store.state.offices" v-bind:key="office.office_id">
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
    name: "patient-office",
    data() {
        return {
            offices: [],
            office: {
                officeId: null,
                nae: '',
                address: null,
                phone: '',
                email: '',
                startHours: '',
                endHours: '',
                specialty: '',
                hourlyRate: null
            }
        }
    },
    
   
  methods: {
        retrieveOffices() {
            OfficeService.getPatientsOffice(this.$store.state.user).then(response => {
                this.$store.commit("SET_OFFICE", response.data);
                console.log(response);
            });
        }
    },
    created() {
            this.retrieveOffices();
        }
}
</script>


<style scoped>

</style>