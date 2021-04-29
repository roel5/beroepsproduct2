package nl.han.jlvo.cookieclicker.store.items;

import nl.han.jlvo.cookieclicker.autohelper.AutoHelper;

public interface IStoreItemClickListener {
    void onStoreItemClicked(AutoHelper autoHelper);
    void onUpgradeStoreItemClick(AutoHelper autoHelper);
}
