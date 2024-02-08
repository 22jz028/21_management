/**
 * モジュール化していろんなとこから呼べるようにしたJS
 */

/**
 * 通信用メソッド
 */
export async function ajax(url, m, data) {
  const obt = {
    method: m,
    headers: {
      "Content-Type": "application/json",
    },
  }
  if (data) {
    obt.body = JSON.stringify(data);
  }
	console.log(obt);
  // Default options are marked with *
  const response = await fetch(url, obt);
  console.log(url);
  console.log(obt);
  return response.json(); // parses JSON response into native JavaScript objects
}
/**
 * GETパラメータを取得するメソッド
 * @param url 呼び出し元のURL。通常はwindow.locationを入れる
 * @return GETパラメータのオブジェクト
 */
export function GetParameter(url) {
  const searchParams = new URLSearchParams(url.search);
  const obt = {};
  for(const p of searchParams) {
    obt[p[0]] = p[1];
  }

  // console.log(obj);
  return obt;
}