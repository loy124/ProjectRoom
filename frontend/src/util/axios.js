import axios from 'axios';
const DOMAIN = 'http://localhost:8081/api/';

export default request = (method, url, data) => {
    return axios({
            method: method,
            url: DOMAIN + url,
            data: data,
        })
        .then(result => result.data)
        .catch(error => {
            console.log(error);
        });
};

// export const request = {
//     registerUser() {
//         return request('post', 'user/register');
//     },
// };