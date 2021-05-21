import React, {useEffect} from 'react';
import { connect } from 'react-redux';
import OrderItem from '../../components/OrderItem/OrderItem';
import OrderListHeader from '../../components/OrderListHeader/OrderListHeader';
import { fetchUserOrders } from '../../actions';

const Orders = (props) => {
    useEffect(() => {
        props.onFetchUserOrders(1);
        console.log('page orders:', props.orders)
    }, [])
    return (
        <>
            <div className="container" style={{ paddingTop: '6rem' }}>
                <div className="card">
                    <div className="card-header bg-dark text-light">
                            Your Orders
                    </div>
                    <div className="card-body">
                        {props.orders != undefined && props.orders.length ?
                        <OrderListHeader/> : null }
                        {props.orders != undefined && props.orders.length ? props.orders.map(order => (
                            <OrderItem {...order} />
                        )) : <h1 className="display-4 mt-5 text-center">There is no orders</h1>}
                    </div>
                </div>
            </div>
        </>
    );
};


const mapStateToProps = state => {
    return {
        orders: state.orderReducer.orders
    }
}

const mapDispatchToProps = dispatch => ({
    onFetchUserOrders: userId => dispatch(fetchUserOrders(userId))
})

export default connect(mapStateToProps, mapDispatchToProps)(Orders);
