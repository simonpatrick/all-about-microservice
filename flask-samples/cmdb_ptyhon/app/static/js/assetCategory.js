/**
 * Created by patrick on 15/12/30.
 */


new Vue({
    el: '#asset_info',
    data: {
        assets_category: [
            "category1", "category2", "category3"
        ],
        assets_category_attributes: [
            {"category1": ["运维1", "运维4", "运维5", "运维6"]},
            {"category2": ["运维1", "运维2", "运维3", "运维6"]},
            {"category3": ["运维1", "运维2", "运维3", "运维4", "运维5"]}
        ]
    }
});