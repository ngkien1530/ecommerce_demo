import React from 'react';
import { connect } from 'react-redux';

const OrderListHeader = () => {
    return (
        <>
        <div className="container">
            <div className="row">
                <div className="col-sm">
                    Order ID
                </div>
                <div className="col-sm">
                    Puchase Time
                </div>
                <div className="col-5">
                    Description
                </div>
                <div className="col-sm">
                    Amount
                </div>
                <div className="col-sm">
                    Status
                </div>
            </div>
        </div>
        <hr  style={{
            color: '#000000',
            backgroundColor: '#000000',
            height: .5,
            borderColor : '#000000',
            opacity: 0.2
        }}/>  
        </>     
    );
};

export default connect()(OrderListHeader);
