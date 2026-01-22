package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Mb4Id;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * IDマスタ削除
 *
 * @author emarfkrow
 */
public class Mb4IdDeleteAction extends BaseAction {

    /** IDマスタ削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object refId = postJson.get("refId");
        if (refId == null) {
            refId = postJson.get("Mb4Id.refId");
        }
        if (refId == null) {
            throw new OptLockError("error.cant.delete", "IDマスタ");
        }

        Mb4Id e = FormValidator.toBean(Mb4Id.class.getName(), postJson);

        java.util.List<com.example.entity.Mb4Idbn> mb4Idbns = e.referMb4Idbns();
        if (mb4Idbns != null) {
            for (com.example.entity.Mb4Idbn mb4Idbn : mb4Idbns) {

                if (mb4Idbn.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "ID連番マスタ");
                }
            }
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "IDマスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
