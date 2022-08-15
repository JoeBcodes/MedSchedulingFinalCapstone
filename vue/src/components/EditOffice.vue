<template>
    <div>
        <button v-on:click="showForm">Edit Office Info</button>

        <form v-if="isShown">
            <label for="name">Office Name</label>
            <input type="text" name="name" v-model="office.name" />
            <label for="address">Address</label>
            <input type="text" name="address" v-model="office.address" />
            <label for="email">Office Email</label>
            <input type="text" name="email" v-model="office.email" />
            <label for="startTime">Opens at: </label>
            <input type="time" name="startTime" step="2" v-model="office.startHours" />
            <label for="endTime">Closes at: </label>
            <input type="time" name="endTime" step="2" v-model="office.endHours" />
            <label for="specialty">Specialty: </label>
            <input type="text" name="specialty" v-model="office.specialty" />
            <label for="hourlyRate">Hourly rate of services: </label>
            <input type="text" name="hourlyRate" v-model="office.hourlyRate" />
            <input type="submit" name="Update" v-on:click.prevent="editOfficeDetail" />

        </form>
    </div>
</template>

<script>
import OfficeService from '../services/OfficeService.js';

export default {
    name: 'editOffice',
    data() {
        return {
            office: {},
            isShown: false,
        }
    },
    components: {

    },
    computed: {

    },
    methods: {
        showForm() {
            this.isShown = !this.isShown;
            this.office = {
                ...this.$store.state.office
            }
        },
        editOfficeDetail() {
            console.log(this.office)
            OfficeService.updateOfficeInfo(this.office).then(response => {
                if (response.status === 200) {
                    this.$store.commit("SET_OFFICE", {
                        ...this.office
                    });
                }
            });
        }
    }
}
</script>
