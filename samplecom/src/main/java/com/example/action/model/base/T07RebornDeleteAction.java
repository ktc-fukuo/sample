package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T07Reborn;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 転生削除
 *
 * @author emarfkrow
 */
public class T07RebornDeleteAction extends BaseAction {

    /** 転生削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object rebornId = postJson.get("rebornId");
        if (rebornId == null) {
            rebornId = postJson.get("T07Reborn.rebornId");
        }
        if (rebornId == null) {
            throw new OptLockError("error.cant.delete", "転生");
        }

        T07Reborn e = FormValidator.toBean(T07Reborn.class.getName(), postJson);

        java.util.List<com.example.entity.T07RebornDet> t07RebornDets = e.referT07RebornDets();
        if (t07RebornDets != null) {
            for (com.example.entity.T07RebornDet t07RebornDet : t07RebornDets) {

                if (t07RebornDet.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "転生明細");
                }
            }
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "転生");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
