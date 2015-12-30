/**
 * Created by patrick on 15/12/30.
 */

new Vue({
    el: '#menu_container',
    data:{
        menu_items: [
            {"name":"资产","resource":'/assets'},
            {"name":"虚拟机管理","resource":'/vm'},
            {"name":"IP管理","resource":'/ip'},
            {"name":"物理机管理","resource":'/machine'}
        ]
    }
});