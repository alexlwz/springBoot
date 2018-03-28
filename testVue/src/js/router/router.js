import welcomeComponent from './../components/admin_base/welcome.vue';
import cashList from './../components/sale/cash/cashList.vue';
//路由控制
let snavRouter = [
    {
        path: '/',
        redirect: '/index?pos=0'
    },
    {
        path: '/index',
        component: welcomeComponent
    },
    {
        path: '/cash/cashList',
        component: cashList
    }
];
export {snavRouter}