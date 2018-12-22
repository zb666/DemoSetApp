package com.example.daggerdemo.multiple;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.daggerdemo.R;
import com.example.daggerdemo.bean.PersonMultipleItem;
import com.example.daggerdemo.bean.Section;

import java.util.List;

//分组布局
public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<PersonMultipleItem, BaseViewHolder> {

    public MultipleItemQuickAdapter(List<PersonMultipleItem> data) {
        super(data);
        addItemType(PersonMultipleItem.TEXT, R.layout.item_text);
        addItemType(PersonMultipleItem.IMAGE, R.layout.item_image);
    }

    @Override
    protected void convert(BaseViewHolder helper, PersonMultipleItem item) {
        int itemType = helper.getItemViewType();
        switch (itemType) {
            case PersonMultipleItem.TEXT:
                helper.setText(R.id.tvMul, item.getContext());
//                helper.setBackgroundRes(R.id.tvMul,R.drawable.ic_launcher_round);
                break;
            case PersonMultipleItem.IMAGE:
                helper.setText(R.id.tvImage, item.getContext());
                break;
            default:
                break;
        }
    }
}
