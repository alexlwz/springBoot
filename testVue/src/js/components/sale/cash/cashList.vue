<template>
<div class ="page-cash-list">
    <div class="cash-title">
        <span>回款管理</span>
    </div>
    <div>{{timestamp}}</div>
    <div class="cash-search">
        <span class="fs14 mr15">筛选:</span>
        <el-button type="primary" size="small" icon="search"></el-button>
        <el-button type="danger" size="small">重置</el-button>
    </div>
    <div class="cash-table">
    <el-table :data="type_options" border style="width: 100%" highlight-current-row>
        <el-table-column label="编号" width="180">
            <template scope="scope">
                <a href="javascript:;">{{scope.row.label}}</a>
            </template>
        </el-table-column>
        
        <el-table-column label="客户名称" width="200">
            <template scope="scope">
                <span>{{ scope.row.info }}</span>
            </template>
        </el-table-column>
        ....
    </el-table>
</div>
</div>
    <!-- <div class="welcome-wrap">
        <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522243254438&di=dcc1322e23b69697ee1275e7bc5c5ca9&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fw%3D580%2Fsign%3Da4fa636364d9f2d3201124e799ed8a53%2F974ef6246b600c33584a824a1c4c510fd9f9a12b.jpg" alt="">
    </div> -->
</template>
<script>
    export default{
        data(){
            return{
                timestamp,
                type_options: []
            }
            // cashList: [
            //         {
            //             "cashId": "M2017062900049001",
            //             "ordId": "O2017062900075030",
            //             "cashType": 0,
            //             "payChannel": null,
            //             "payType": null,
            //             "cashStatus": 0,
            //             "custoName": "UFO",
            //             "userName": "陈",
            //             "userMobile": "16936025651",
            //             "merchandisers": "文",
            //             "cashAmount": 1832500,
            //             "cashDate": 1498718850000,
            //             "cashAccountType": 0,
            //             "payNo": null
            //         },
            //         {
            //             "cashId": "M2017062900049002",
            //             "ordId": "O2017062900075031",
            //             "cashType": 0,
            //             "payChannel": null,
            //             "payType": null,
            //             "cashStatus": 0,
            //             "custoName": "UFO",
            //             "userName": "天使",
            //             "userMobile": "13926085651",
            //             "merchandisers": "乐",
            //             "cashAmount": 1832500,
            //             "cashDate": 14987188558400,
            //             "cashAccountType": 0,
            //             "payNo": null
            //         }]
            //     //name:'cashList'
            // }
        },
        //请求后端 
         methods: {
            trantime: function () {           
                    this.$axios.get("http://localhost:8085/lwz/Account/info")
                        .then((response) => {
                            this.type_options = response.data;
                            console.log(response.data);
                        }).catch(function (response) {
                        console.log(response)
                    });
            },
         }
    }
</script>
<style lang="scss" scoped>
    .welcome-wrap{
        height: 100%;
        width: 100%;
        img{
            display: block;
            width: 100%;
            height: 100%;
        }
        .hd{
            font-size: 30px;
            text-align: center;
        }
        .bd{

        }
    }
</style>
<style lang="scss">
    .welcome-steps{
        .el-step__line-inner{
            height: 100% !important;
        }
    }
</style>