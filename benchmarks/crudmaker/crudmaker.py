from app import create_app

crud_maker = create_app('conf.config')

if __name__ == '__main__':
    crud_maker.run(host=crud_maker.config['HOST'],
                   port=crud_maker.config['PORT'],
                   debug=crud_maker.config['DEBUG'])