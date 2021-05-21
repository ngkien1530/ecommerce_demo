import React from 'react';
import { connect } from 'react-redux';

const OrderListHeader = () => {
    return (
        <>
        <div className="container">
            <div className="row">
                <div className="col-2">
                    Order ID
                </div>
                <div className="col-2">
                    Puchase Time
                </div>
                <div className="col-4">
                    Description
                </div>
                <div className="col-2">
                    Amount
                </div>
                <div className="col-2">
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
