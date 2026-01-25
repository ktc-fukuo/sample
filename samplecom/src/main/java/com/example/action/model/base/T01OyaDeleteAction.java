package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T01Oya;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 親削除
 *
 * @author emarfkrow
 */
public class T01OyaDeleteAction extends BaseAction {

    /** 親削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object oyaId = postJson.get("oyaId");
        if (oyaId == null) {
            oyaId = postJson.get("T01Oya.oyaId");
        }
        if (oyaId == null) {
            throw new OptLockError("error.cant.delete", "親");
        }

        T01Oya e = FormValidator.toBean(T01Oya.class.getName(), postJson);

        java.util.List<com.example.entity.T01Dinks> t01Dinkss = e.referT01Dinkss();
        if (t01Dinkss != null) {
            for (com.example.entity.T01Dinks t01Dinks : t01Dinkss) {

                if (t01Dinks.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "子なし");
                }
            }
        }


        java.util.List<com.example.entity.T01Ko> t01Kos = e.referT01Kos();
        if (t01Kos != null) {
            for (com.example.entity.T01Ko t01Ko : t01Kos) {

                // child:T01Mago, parents:2


                if (t01Ko.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "子");
                }
            }
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "親");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
