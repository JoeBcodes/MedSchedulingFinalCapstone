<template>
    <div id="formContainer">
        <button v-on:click="showForm">Edit Office Info</button>

        <form v-if="isShown">
            <div class="formItemBox">
                <label for="name">Office Name</label>
                <input type="text" name="name" v-model="office.name" />
            </div>
            <div class="formItemBox">
                <label for="address">Address</label>
                <input id="address" type="text" name="address" v-model="office.address" />
            </div>
            <div class="formItemBox">
                <label for="email">Office Email</label>
                <input type="text" name="email" v-model="office.email" />
            </div>
            <div class="formItemBox">
                <table>
                    <tr>
                        <td>
                            <label for="startTime">Opens at: </label>
                            <input type="time" name="startTime" step="2" v-model="office.startHours" />
                        </td>
                        <td>
                            <label for="endTime">Closes at: </label>
                            <input type="time" name="endTime" step="2" v-model="office.endHours" />
                        </td>
                    </tr>
                </table>
            </div>
            <div class="formItemBox">
                <label for="specialty">Specialty: </label>
                <input type="text" name="specialty" v-model="office.specialty" />
            </div>
            <div class="formItemBox">
                <label for="hourlyRate">Hourly rate of services: </label>
                <input type="text" name="hourlyRate" v-model="office.hourlyRate" />
            </div>
            <input id="submit" type="submit" name="Update" v-on:click.prevent="editOfficeDetail" />

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
            this.isShown = false;
            });
        }
    }
}
</script>

<style>
#formContainer {
    width: 75%;
}
.formItemBox {
    background-color: #f1f1f1d8;
    border-radius: 20px;
    width: 450px;
    padding: 20px;
    margin:10px 20px 10px 0;
    font-size: 20px;
}
.formItemBox input {
    font-size: 20px;
}
td {
    padding-right:50px;
}
#address {
    width: 400px;
}
#submit {
    display: block;
}
</style>
