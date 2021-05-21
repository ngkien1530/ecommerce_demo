import { orderService } from "../http-common";

const doFetchUserOrders = userId => {
    return new Promise((resolve, reject) => {
        orderService.get("/orders/${userId}", userId)
        .then(response => {
            console.log('data: ', response.data);
            return resolve(response.data)}
        )
        .catch(error => reject(error))
    })
}

export default doFetchUserOrders;
