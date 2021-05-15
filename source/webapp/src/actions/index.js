import doFetchUserOrders from "../services/order.service";
import orderService from "../http-common";

export const ADD_PRODUCT_TO_CART = 'ADD_PRODUCT_TO_CART';
export const REMOVE_PRODUCT_FROM_CART = 'REMOVE_PRODUCT_FROM_CART';
export const INCREMENT_CART_ITEM_QUANTITY = 'INCREMENT_CART_ITEM_QUANTITY';
export const DECREMENT_CART_ITEM_QUANTITY = 'DECREMENT_CART_ITEM_QUANTITY';

export const addProductToCart = product => {
    return {
        type: ADD_PRODUCT_TO_CART,
        payload: product
    }
};

export const removeProductToCart = productId => {
    return {
        type: REMOVE_PRODUCT_FROM_CART,
        payload: productId
    }
};

export const incrementCartQuantity = productId => {
    return{
        type: INCREMENT_CART_ITEM_QUANTITY,
        payload: productId
    }
};

export const decrementCartQuantity = productId => {
  return {
      type: DECREMENT_CART_ITEM_QUANTITY,
      payload: productId
  }
};


export const ADD_BRAND_TO_FILTER = 'ADD_BRAND_TO_FILTER';
export const REMOVE_BRAND_FROM_FILTER = 'REMOVE_BRAND_FROM_FILTER';

export const addBrandToFilter = brand => {
    return {
        type: ADD_BRAND_TO_FILTER,
        brand
    }
};


export const removeBrandFromFilter = brand => {
    return  {
        type: REMOVE_BRAND_FROM_FILTER,
        brand
    }
};

export const ORDER_BY_ASC = 'ORDER_BY_ASC';
export const ORDER_BY_DESC = 'ORDER_BY_DESC';
export const CLEAR_ORDER_BY_PRICE = 'CLEAR_ORDER_BY_PRICE';

export const orderByAsc = () => {
    return {
        type: ORDER_BY_ASC
    }
};

export const orderByDesc =  () => {
    return {
        type: ORDER_BY_DESC
    }
};

export const clearOrderBy = () => {
    return {
        type: CLEAR_ORDER_BY_PRICE
    }
};


export const PREV_PAGE = 'PREV_PAGE';
export const NEXT_PAGE = 'NEXT_PAGE';
export const GO_PAGE = 'GO_PAGE';
export const COUNT_ITEM = 'COUNT_ITEM';


export const nextPage = () => {
    return {
        type: NEXT_PAGE
    }
};

export const prevPage = () => {
    return {
        type: PREV_PAGE
    }
};

export const goPage = (n) => {
    return {
        type: GO_PAGE,
        currentPage: n
    }
};

export const countItem = (n) => {
    return {
        type: COUNT_ITEM,
        totalItemsCount: n
    }
}


export const LOAD_ORDERS = 'LOAD_ORDERS';
export const LOAD_ORDERS_SUCCESS = 'LOAD_ORDERS_SUCCESS';
export const LOAD_ORDERS_FAILED = 'LOAD_ORDERS_FAILED';

export const fetchUserOrders = userId => {
    return dispatch => {
      dispatch(fetchUserOrdersStarted());
      orderService.get("/transactions/1")
        .then(res => {
            console.log('Success: ', res)
            dispatch(fetchUserOrdersSuccess(res.data))}
            )
        .catch(error => {
            console.log('Failed: ', error)
            dispatch(fetchUserOrdersFailed(error))
        })
    }
  }

const fetchUserOrdersStarted = () => (
    {
        type: LOAD_ORDERS
    }
)

const fetchUserOrdersSuccess = (orders) => (
    {
        type: LOAD_ORDERS_SUCCESS,
        payload: {
            orders
        }
    }
)

const fetchUserOrdersFailed = (error) => (
    {
        type: LOAD_ORDERS_FAILED,
        payload: {
            error
        }
    }
)