/**
 * 孤児グリッド定義
 */

let T01OrphanGridColumns = [];

$(function() {
    T01OrphanGridColumns = [
        Column.text('OYA_ID', Messages['T01OrphanGrid.oyaId'], 90, 'primaryKey numbering', null),
        Column.text('KO_BN', Messages['T01OrphanGrid.koBn'], 90, 'primaryKey numbering', null),
        Column.text('ORPHAN_INFO', Messages['T01OrphanGrid.orphanInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T01OrphanGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
