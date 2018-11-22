import React, { Fragment } from 'react';

const VisitForm = ({ handleChange, handleSubmit }) => {
    return (
        <Fragment>
            <form className="form-horizontal" onSubmit={handleSubmit} method="post">
                <div className="form-group has-feedback">
                    <div className="form-group">
                        <label className="col-sm-2 control-label">Date</label>
                        <div className="col-sm-10">
                            <div>
                                <input
                                    className="form-control"
                                    type="text"
                                    placeholder="YYYY-MM-DD"
                                    title="Enter a date in this format: YYYY-MM-DD"
                                    pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
                                    id="date"
                                    name="date"
                                    value="2018-11-22"
                                    onChange={handleChange} />
                            </div>
                            <span className="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                        </div>
                    </div>
                    <div className="form-group">
                        <label className="col-sm-2 control-label">Description</label>
                        <div className="col-sm-10">
                            <div>
                                <input className="form-control" type="text" id="description" name="description" value="" onChange={handleChange} />
                            </div>
                            <span className="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                        </div>
                    </div>
                </div>
                <div className="form-group">
                    <div className="col-sm-offset-2 col-sm-10">
                        <input type="hidden" name="petId" value="2" />
                        <button className="btn btn-default" type="submit">Add Visit</button>
                    </div>
                </div>
            </form>
        </Fragment>
    )
}

export default VisitForm