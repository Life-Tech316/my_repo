var app = new Vue({
    el: '#app',
    data:{
        num: 29.54
    },
    methods: {
        changeMsg1: function(){
            this.msg1 = 'こんにちわVue.js';
        }
    }
});
