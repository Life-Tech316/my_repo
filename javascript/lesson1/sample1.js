var app = new Vue({
    el: '#app',
    data:{
        msg: "こんにちわ",
        msg1: '初めてのVue.js',
        msg2: 'Vue.js'
    },
    methods: {
        changeMsg1: function(){
            this.msg1 = 'こんにちわVue.js';
        }
    }
});
