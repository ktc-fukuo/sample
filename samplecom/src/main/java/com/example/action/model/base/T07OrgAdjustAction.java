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
 * 起源更新
 *
 * @author emarfkrow
 */
public class T07OrgAdjustAction extends BaseAction {

    /** 起源更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object orgId = form.get("orgId");
        if (orgId == null) {
            orgId = form.get("T07Org.orgId");
        }
        if (orgId == null) {
            throw new OptLockError("error.cant.adjust", "起源");
        }

        T07Org e = FormValidator.toBean(T07Org.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "起源");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
