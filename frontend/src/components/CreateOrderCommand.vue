<template>

    <v-card outlined>
        <v-card-title>
            CreateOrder
        </v-card-title>

        <v-card-text>
            <String label="CustomerLocation" v-model="value.customerLocation" :editMode="editMode"/>
            <String label="DestinationLocation" v-model="value.destinationLocation" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createOrder"
            >
                CreateOrder
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'CreateOrderCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.customerLocation = '';
            this.value.destinationLocation = '';
        },
        watch: {
        },
        methods: {
            createOrder() {
                this.$emit('createOrder', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

