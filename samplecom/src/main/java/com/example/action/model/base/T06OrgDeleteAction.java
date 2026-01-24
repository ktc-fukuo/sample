package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T06Org;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 起源削除
 *
 * @author emarfkrow
 */
public class T06OrgDeleteAction extends BaseAction {

    /** 起源削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object orgId = postJson.get("orgId");
        if (orgId == null) {
            orgId = postJson.get("T06Org.orgId");
        }
        if (orgId == null) {
            throw new OptLockError("error.cant.delete", "起源");
        }

        T06Org e = FormValidator.toBean(T06Org.class.getName(), postJson);

        java.util.List<com.example.entity.T06OrgDet> t06OrgDets = e.referT06OrgDets();
        if (t06OrgDets != null) {
            for (com.example.entity.T06OrgDet t06OrgDet : t06OrgDets) {

                if (t06OrgDet.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "起源明細");
                }
            }
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "起源");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
