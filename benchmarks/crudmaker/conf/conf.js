/**
 * Created by patrick on 16/2/5.
 */
exports.config= {
    framework: 'jasmine',
    seleniumAddress: 'http://localhost:4444/wd/hub',
    specs: [
        'app/templates/users/spec.js'
    ]
};

//todo how about kamma