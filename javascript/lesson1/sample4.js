var app = new Vue({
    el: '#app',
    data:{
        msg: "こんにちわ"
    },
    methods: {
        changeMsg1: function(){
            this.msg1 = 'こんにちわVue.js';
        }
    }
});
