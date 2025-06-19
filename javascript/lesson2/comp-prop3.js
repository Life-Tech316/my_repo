var app = new Vue({
    el: '#app',
    data: {
        hankei: 10,
        msg: 'Hello'
        },
    computed: {
        dateProp: function(){
            return new Date().toLocaleString();
        }
    },
    methods: {
        dateMethod: function(){
            return new Date().toLocaleString();
        }
    }
});
