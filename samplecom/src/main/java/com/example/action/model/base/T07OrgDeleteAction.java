package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T07Org;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 起源削除
 *
 * @author emarfkrow
 */
public class T07OrgDeleteAction extends BaseAction {

    /** 起源削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object orgId = form.get("orgId");
        if (orgId == null) {
            orgId = form.get("T07Org.orgId");
        }
        if (orgId == null) {
            throw new OptLockError("error.cant.delete", "起源");
        }

        T07Org e = FormValidator.toBean(T07Org.class.getName(), form);

        // 子：起源明細を全て指定済みか確認
        int orgT07OrgDetsSize = e.getT07OrgDets().size();
        if (e.referT07OrgDets().size() != orgT07OrgDetsSize) {
            throw new OptLockError("error.cant.delete", "起源明細");
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "起源");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
