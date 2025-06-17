var app = new Vue({
    el: '#app',
    data: {
        color: 'blue',
        align: 'center',
        size: '3em',
    },
    method: {
      setAlign: function(align){
        this.align = align;
      }
    }
});
