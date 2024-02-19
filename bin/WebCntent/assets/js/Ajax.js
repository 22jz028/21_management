export default async function  Ajax(url = '', m = 'GET', data) {
    
    const opt = {
        method: m,
        headers: {
            'Content-Type': 'application/json'
        }
    };
    
    if (data) { //送る専用data
        opt.body = JSON.stringify(data);
    }
    
    const response = await fetch(url ,opt); 
    return response.json();
}
