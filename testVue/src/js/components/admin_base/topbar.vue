<template>
    <div class="topbar">
        <el-button class="fr mr30 mt15" type="primary" size="small" @click="loginOut">退出登录</el-button>
    </div>
</template>

<script>
    export default{
        data(){
            return {
                name: 'topbar'
            }
        },
        methods: {
            loginOut(){
                //...
            }
        },
        mounted(){

        }
    }
</script>
<style lang="scss" scoped>
    .topbar {
        width: 100%;
        height: 60px;
    }
</style>