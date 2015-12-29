# OPS resources

## Assert

```
   - GET /asset
   - POST /asset
   - PUT /asset
   - Delete /assert
```

- create asset
- update asset
- get assert list
- de-active asset

## configuration

## workflow

## deployment

## design

- Backend:
    * postgresql
    * python flask
    * python restful api
    * vuejs
    * bootstrap
    
- tables

一种设计思路:

```
 asset_category: 资产种类
 asset_attributes : 资产属性
 asset_attribute_values: 资产属性值
 assets: 实际的使用中的资产,可以是物理的,可以是虚拟的,可以根据IP的
 assets_history: 资产使用情况
```

另外一种设计思路:

```
 asset_category: 资产种类
 asset_attributes : 资产属性
 assets: 实际的使用中的资产,可以是物理的,可以是虚拟的,可以根据IP的, 详细的描述使用JSON保存,类似于NOSQL
 assets_history: 资产使用情况

```

## salt vs ansible

Think about it