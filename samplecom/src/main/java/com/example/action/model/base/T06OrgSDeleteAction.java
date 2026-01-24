package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.T06Org;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 起源一覧削除
 *
 * @author emarfkrow
 */
public class T06OrgSDeleteAction extends BaseAction {

    /** 起源一覧削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("T06OrgGrid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                // 主キーが不足していたらエラー
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("ORG_ID"))) {
                    throw new OptLockError("error.cant.delete", "起源");
                }

                T06Org e = FormValidator.toBean(T06Org.class.getName(), row);

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
                ++count;
            }
        }

        if (count == 0) {
            map.put("ERROR", Messages.get("error.nopost"));
            return map;
        }

        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
