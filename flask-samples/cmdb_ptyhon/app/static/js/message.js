/**
 * Created by patrick on 15/12/30.
 */

new Vue({
    el: '#personal_info',
    data:{
        messages: [
            {"sender":"运维","content":'this is a test message'},
            {"sender":"运维1","content":'this is a test message'}
        ],
        tasks: [
            {"name":"运维","completion":'20%'},
            {"name":"运维1","completion":'80%'}
        ]
    }
});
